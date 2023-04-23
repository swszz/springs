package com.swszz.guides.spring.buddy.member.adapter.in.web;

import com.swszz.guides.spring.buddy.WebAdapter;
import com.swszz.guides.spring.buddy.member.application.port.in.BrowseMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : swszz
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class BrowseMemberController {
    private final BrowseMemberUseCase browseMemberUseCase;
}
