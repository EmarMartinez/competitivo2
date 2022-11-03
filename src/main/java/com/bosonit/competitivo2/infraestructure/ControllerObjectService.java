package com.bosonit.competitivo2.infraestructure;

import com.bosonit.competitivo2.model.ControllerObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ControllerObjectService {

    public ControllerObject returnControllerObject(String path, String params, String origen, HttpServletRequest request) {

        List<String> paths = new ArrayList<> (Arrays.asList(path.split("/")));
        paths.remove(0);


        List<String> queries = new ArrayList<> (Arrays.asList(params.split("&")));


        Map<String, String> queryparams = new HashMap<>();
        queries.stream().forEach(n->queryparams.put(n.split("=")[0],n.split("=")[1]));


        Map<String, String> headers = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers.put(key,value);
        }


        return new ControllerObject(paths, queryparams, headers, origen);
    }
}
