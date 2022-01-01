package be.jorisgulinck.homeaid.product;

import be.jorisgulinck.homeaid.shared.Packaging;
import be.jorisgulinck.homeaid.shared.Volume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    //private Set<String> alias;
    private String description;
    //private List<String> images;
    private Packaging packaging;
    private Volume volume;

}
