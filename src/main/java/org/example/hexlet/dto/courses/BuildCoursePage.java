package org.example.hexlet.dto.courses;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildCoursePage {
    //Map with errors
    private Map<String, List<ValidationError<Object>>> errors;
}
