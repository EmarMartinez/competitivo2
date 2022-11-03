package com.bosonit.competitivo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ControllerObject {
    List<String> paths;
    Map<String, String> querys;
    Map<String, String> headers;
    String origen;
}
