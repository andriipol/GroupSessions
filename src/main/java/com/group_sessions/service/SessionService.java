package com.group_sessions.service;

import com.group_sessions.dto.GeolocationAreaDto;
import com.group_sessions.dto.SessionDTO;
import com.group_sessions.entity.Geolocation;
import com.group_sessions.entity.Habit;
import com.group_sessions.entity.Session;
import com.group_sessions.repository.GeolocationRepository;
import com.group_sessions.repository.HabitRepository;
import com.group_sessions.repository.SessionRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SessionService {
    private SessionRepository sessionRepository;
    private HabitRepository habitRepository;
    private GeolocationRepository geolocationRepository;

    public SessionService(SessionRepository sessionRepository,
                          HabitRepository habitRepository,
                          GeolocationRepository geolocationRepository) {
        this.sessionRepository = sessionRepository;
        this.habitRepository = habitRepository;
        this.geolocationRepository = geolocationRepository;
    }

    public List<SessionDTO> getAllSessions() {
        return sessionRepository.findAll().stream().map(SessionDTO::new).collect(Collectors.toList());
    }

    public SessionDTO getSessionById(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found by id " + sessionId));
        return new SessionDTO(session);
    }

    public List<Session> getSessionByHabit(Long habitId) {
        return sessionRepository.findAllByHabit_Id(habitId);
    }

    public Session createSession(final SessionDTO sessionDTO) {
        Session session = new Session();

        session.setTitle(sessionDTO.getTitle());
        session.setCapacity(sessionDTO.getCapacity());
        session.setStart_date(sessionDTO.getStart_date());
        session.setDuration(sessionDTO.getDuration());
        session.setLocation(sessionDTO.getLocation());
        session.setOrganizer(sessionDTO.getOrganizer());
        session.setSummary(sessionDTO.getSummary());
        session.setHost_email(sessionDTO.getHost_email());
        session.setJoin_url(sessionDTO.getJoin_url());

        Habit habit = habitRepository.findById(sessionDTO.getHabit_id())
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found by id " + sessionDTO.getHabit_id()));
        session.setHabit(habit);

        session.setGeolocation(saveGeolocation(sessionDTO));

        return sessionRepository.save(session);
    }

    private Geolocation saveGeolocation(SessionDTO sessionDTO) {
        Geolocation geolocation = new Geolocation();
        geolocation.setLatitude(sessionDTO.getLatitude());
        geolocation.setLongitude(sessionDTO.getLongitude());
        geolocation.setAddress(sessionDTO.getAddress());
        return geolocationRepository.save(geolocation);
    }

    public void deleteSession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Session not found by id " + sessionId));
        sessionRepository.delete(session);
    }

    public void updateSessionUrl(Long sessionId, String hostMail) {
        Session session = sessionRepository.findById(sessionId).
                orElseThrow(() -> new ResourceNotFoundException("Session not found by id " + sessionId));
        session.setJoin_url(hostMail);
        sessionRepository.save(session);
    }

    public List<SessionDTO> getSessionByGeoLocation(GeolocationAreaDto geolocationAreaDto) {
//        return sessionRepository.findWIthGeolocation();
        return sessionRepository.findWIthGeolocation(
                geolocationAreaDto.getLongitudeNE(),
                geolocationAreaDto.getLatitudeNE(),
                geolocationAreaDto.getLongitudeSW(),
                geolocationAreaDto.getLatitudeSW()).stream().map(SessionDTO::new).collect(Collectors.toList());
    }


}
