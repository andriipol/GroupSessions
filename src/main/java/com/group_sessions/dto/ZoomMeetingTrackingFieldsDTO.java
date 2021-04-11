package com.group_sessions.dto;

import lombok.Data;

@Data
public class ZoomMeetingTrackingFieldsDTO {
    public String field;

    public String value;

    public Boolean visible;

    @Override
    public String toString() {
        return "ZoomMeetingTrackingFieldsDTO [field=" + getField() + ", value=" + getValue() + ", visible=" + getVisible() + "]";
    }
}
