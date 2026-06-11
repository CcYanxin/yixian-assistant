package com.yixian.ai;

import com.yixian.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiQueryService aiQueryService;

    @PostMapping("/query")
    public Result<AiQueryService.AiQueryResponse> query(@RequestBody AiQueryRequest req) {
        return Result.ok(aiQueryService.query(req.getQuestion()));
    }
}
