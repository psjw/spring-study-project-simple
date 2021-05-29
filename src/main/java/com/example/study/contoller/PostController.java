package com.example.study.contoller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//메소드는는 RequestMapping 동일하게 사용 못함
public class PostController {
    //HTML<Form>
    //ajax 검색
    // http post body -> data
    // json, xml, multipart-form / text-plain

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
//    @PostMapping(value = "/postMethod", produces = {"application/json"}) -->  json, xml, multipart-form / text-plain 형식 설정 가능
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }
}
