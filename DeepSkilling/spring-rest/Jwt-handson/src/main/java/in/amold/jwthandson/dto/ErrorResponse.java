package in.amold.jwthandson.dto;


public record ErrorResponse(
        int status,
        String error,
        String message,
        long timestamp
) {}