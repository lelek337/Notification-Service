package notification.service.space.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "push_inbox")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushInboxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Column(name = "\"key\"", nullable = false)
    private String key;

    @Column(name = "value", nullable = false, columnDefinition = "text")
    private String value;

    @Column(name = "processed", nullable = false, columnDefinition = "boolean default false")
    private boolean processed;

    @Column(name = "attempt", nullable = false, columnDefinition = "integer default 0")
    private int attempt;
}

