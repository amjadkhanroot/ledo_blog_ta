package com.amjadcode.ledo_blog_ta.authentication.payloads.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record LoginRequest(@NotNull @NotBlank String username) {

}
