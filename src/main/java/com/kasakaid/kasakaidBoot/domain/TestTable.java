package com.kasakaid.kasakaidBoot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
//@Table(name = "TestTable")
@NamedEntityGraph(
        name = "test",
        attributeNodes = @NamedAttributeNode(value = "children")
)
public class TestTable {
    @Id
    private int userId;
    private String userName;

    @Embedded
    //@JoinTable(name = "TestChildTable", joinColumns = @JoinColumn(referencedColumnName = "userId"))
    @CollectionTable( name="TestChildTable", joinColumns=@JoinColumn(name="userId") )
    @ElementCollection(fetch = FetchType.EAGER)
    List<TestChildTable> children;
}
