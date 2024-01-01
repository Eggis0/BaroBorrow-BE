package com.example.subsub.controller;

import com.example.subsub.domain.CouncilItem;
import com.example.subsub.dto.request.AddCouncilItemRequest;
import com.example.subsub.dto.request.UpdateCouncilItemRequest;
import com.example.subsub.dto.response.CouncilItemResponse;
import com.example.subsub.service.CouncilItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/council-item")
@RequiredArgsConstructor
public class CouncilManageItemApiController {

    private final CouncilItemService councilItemService;

    // 생성
    @PostMapping
    public CouncilItemResponse save(@RequestBody AddCouncilItemRequest request, Authentication authentication) {
        CouncilItem councilItem = councilItemService.CouncilSave(request, authentication.getName());
        return new CouncilItemResponse(councilItem);
    }

    // 모두 조회
    @GetMapping("/all")
    public ResponseEntity<List<CouncilItemResponse>> getAllCouncilItem() throws Exception {
        List<CouncilItemResponse> councilItems = councilItemService.getAllCouncilItem();
        return ResponseEntity.ok(councilItems);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCouncilItem(@PathVariable Integer id) {
        ResponseEntity<String> result = councilItemService.deleteCouncilItem(id);
        return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouncilItemResponse>  updateCouncilItem(@PathVariable Integer id, @RequestBody UpdateCouncilItemRequest request) {
        ResponseEntity<CouncilItemResponse> council = councilItemService.update(id, request);
        return council;
    }
}
