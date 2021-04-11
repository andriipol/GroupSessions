package com.group_sessions.service;

import com.group_sessions.dto.ZoomMeetingObjectDTO;
import com.group_sessions.dto.ZoomMeetingSettingsDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Key;
import java.util.Date;
import java.util.UUID;


@Service
public class ZoomMeetingService {
    private static final Logger LOG = LogManager.getLogger(ZoomMeetingService.class.getName());

    @Value("${zoomApiKey}")
    private String zoomApiKey;

    @Value("${zoomApiSecret}")
    private String zoomApiSecret;

    public ZoomMeetingObjectDTO createMeeting(ZoomMeetingObjectDTO zoomMeetingObjectDTO) {
        LOG.debug("Request to create a Zoom meeting");

        String apiUrl = "https://api.zoom.us/v2/users/" + zoomMeetingObjectDTO.getHost_email() + "/meetings";
        zoomMeetingObjectDTO.setPassword("yourPass");

        // Optional Settings for host and participant related options
        ZoomMeetingSettingsDTO settingsDTO = new ZoomMeetingSettingsDTO();
        settingsDTO.setJoin_before_host(false);
        settingsDTO.setParticipant_video(true);
        settingsDTO.setHost_video(false);
        settingsDTO.setAuto_recording("cloud");
        settingsDTO.setMute_upon_entry(true);
        zoomMeetingObjectDTO.setSettings(settingsDTO);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + generateZoomJWTTOken());
        headers.add("content-type", "application/json");
        HttpEntity<ZoomMeetingObjectDTO> httpEntity = new HttpEntity<ZoomMeetingObjectDTO>(zoomMeetingObjectDTO, headers);
        ResponseEntity<ZoomMeetingObjectDTO> zEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, httpEntity, ZoomMeetingObjectDTO.class);
        if (zEntity.getStatusCodeValue() == 201) {
            LOG.debug("Zooom meeeting response {}", zEntity);
            return zEntity.getBody();
        } else {
            LOG.debug("Error while creating zoom meeting {}", zEntity.getStatusCode());
        }
        return zoomMeetingObjectDTO;
    }


    /**
     * Generate JWT token for Zoom using api credentials
     *
     * @return JWT Token String
     */
    private String generateZoomJWTTOken() {
        String id = UUID.randomUUID().toString().replace("-", "");
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Date creation = new Date(System.currentTimeMillis());
        Date tokenExpiry = new Date(System.currentTimeMillis() + (1000 * 60));

        Key key = Keys
                .hmacShaKeyFor(zoomApiSecret.getBytes());

        return Jwts.builder()
                .setId(id)
                .setIssuer(zoomApiKey)
                .setIssuedAt(creation)
                .setSubject("")
                .setExpiration(tokenExpiry)
                .signWith(key, signatureAlgorithm)
                .compact();
    }
}
