package com.yixian.ai;

import com.yixian.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 注意：/ai/extract 由 2号实现（AiService + DeepSeekAiGateway），
// 合并时把 2号的 AiService 注入进来，把 extract 方法实现替换掉。
@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiQueryService aiQueryService;

    // AI④ 管理智脑（6号实现）
    @PostMapping("/query")
    public Result<AiQueryService.AiQueryResponse> query(@RequestBody AiQueryRequest req) {
        return Result.ok(aiQueryService.query(req.getQuestion()));
    }

    // AI① 智能填单（2号实现，待合并）
    @PostMapping("/extract")
    public Result<?> extract(@RequestBody Map<String, String> req) {
        // TODO: 2号合并时替换为 aiService.extract(req)
        return Result.fail("AI① 智能填单接口由2号实现，待合并");
    }
}
