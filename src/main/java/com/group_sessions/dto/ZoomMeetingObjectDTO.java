package com.group_sessions.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ZoomMeetingObjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String uuid;

    private String assistant_id;

    private String host_email;

    private String registration_url;

    private String topic;

    private Integer type;

    private String start_time;

    private Integer duration;

    private String schedule_for;

    private String timezone;

    private String created_at;

    private String password;

    private String agenda;

    private String start_url;

    private String join_url;

    private String h323_password;

    private Integer pmi;

    private ZoomMeetingRecurrenceDTO recurrence;

    private List<ZoomMeetingTrackingFieldsDTO> tracking_fields;

    private List<ZoomMeetingOccurenceDTO> occurrences;

    private ZoomMeetingSettingsDTO settings;

    @Override
    public String toString() {
        return "ZoomMeetingObjectDTO [agenda=" + agenda + ", assistant_id=" + assistant_id + ", created_at="
                + created_at + ", duration=" + duration + ", h323_password=" + h323_password + ", host_email="
                + host_email + ", id=" + id + ", join_url=" + join_url + ", occurrences=" + occurrences + ", password="
                + password + ", pmi=" + pmi + ", recurrence=" + recurrence + ", registration_url=" + registration_url
                + ", schedule_for=" + schedule_for + ", settings=" + settings + ", start_time=" + start_time
                + ", start_url=" + start_url + ", timezone=" + timezone + ", topic=" + topic + ", tracking_fields="
                + tracking_fields + ", type=" + type + ", uuid=" + uuid + "]";
    }

    public ZoomMeetingObjectDTO(SessionDTO sessionDTO){
        this.topic = sessionDTO.getTitle();
        this.start_time = sessionDTO.getStart_date().toInstant().toString();
        this.duration = sessionDTO.getDuration();
        this.host_email = sessionDTO.getHost_email();

    }

}