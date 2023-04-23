package com.swszz.guides.spring.cinema.member.adapter.in.web;

import com.swszz.guides.spring.cinema.member.application.port.in.ModifyMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : swszz
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMemberController {
    private final ModifyMemberUseCase modifyMemberUseCase;
}
