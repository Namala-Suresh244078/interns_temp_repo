package com.mphasis.tflms.enums;

public enum FileErrorSeverity {

    ERROR(3), WARNING(2), INFO(1);

    private final int severityLevel;

    FileErrorSeverity(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }
}
