package com.sketch01.core.domain.onetomany;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_MANY")
@Builder
@Getter
@ToString(exclude = "one")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Many {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MANY_ID", precision = 5, nullable = false)
    private Long manyId;

    @Column(name = "MANY_NAME", length = 10, nullable = false)
    private String manyName;

    @ManyToOne
    @JoinColumn(name = "ONE_ID", nullable = false)
    private One one;

    public void update(String manyName) {
        this.manyName = manyName;
    }

}
