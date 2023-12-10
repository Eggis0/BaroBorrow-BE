package com.example.subsub.dto.request;

import com.example.subsub.domain.Council;
import com.example.subsub.domain.ItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateCouncilItemRequest {
    private String name;
    private ItemType type;
}
