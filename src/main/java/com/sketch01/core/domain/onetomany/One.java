package com.sketch01.core.domain.onetomany;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_ONE")
@Builder
@Getter
@ToString(exclude = "manyList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class One {

    @Id
    @Column(name = "ONE_ID", precision = 5, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oneId;


    @Column(name = "ONE_NAME", length = 10, nullable = false)
    private String oneName;

    public void update(String oneName) {
        this.oneName = oneName;
    }

    /**
     * 삭제인 경우
     *   orphanRemoval = true, cascade = CascadeType.PERSIST 로 설정해야 삭제됨
     *   ex) One one = oneRepository.findById(3L).orElse(null);
     *       List<Many> manyList = one.getManyList();
     *       manyList.remove(1);
     *       oneRepository.save(one);
     *
     * 추가인 경우
     *   cascade = CascadeType.MERGE 로 설정해야 됨.
     *   ex) One one = oneRepository.findById(3L).orElse(null);
     *       List<Many> manyList = one.getManyList();
     *       manyList.add(new Many(null, "name add", one));
     *       oneRepository.save(one);
     *
     * 수정인 경우 cascade 설정안해도 수정 처리 됨
     *   @OneToMany(mappedBy = "one")
     *   ex) One one = oneRepository.findById(3L).orElse(null);
     *       List<Many> manyList = one.getManyList();
     *       manyList.get(0).update("수정");
     *       oneRepository.save(one);
     */
    @OneToMany(mappedBy = "one", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Many> manyList;

}
