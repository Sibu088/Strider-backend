package com.example.striderbackend.controller;
import com.example.striderbackend.dto.ActivityDto;
import com.example.striderbackend.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/activities")
@Tag(name = "Activities", description = "Manage activities")
public class ActivityController {
    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "List all activities")
    public ResponseEntity<List<ActivityDto>> list() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    @Operation(summary = "Create a new activity")
    public ResponseEntity<ActivityDto> create(@Valid @RequestBody ActivityDto dto) {
        ActivityDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/v1/activities/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get activity by id")
    public ResponseEntity<ActivityDto> get(@PathVariable UUID id) {
        return service.get(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update activity")
    public ResponseEntity<ActivityDto> update(@PathVariable UUID id, @Valid @RequestBody ActivityDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete activity")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
