package com.example.demo.repository.specs;


import com.example.demo.model.Invoice;
import lombok.EqualsAndHashCode;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({@Spec(path = "isActive", params = "is_active", spec = Equal.class),
                @Spec(path = "officeId", params = "office_id", spec = Equal.class)}

)
public interface EntitySpec extends Specification<Invoice> {
}
