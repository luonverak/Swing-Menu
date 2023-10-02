package Databases;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ListProduct {
    
    private String name;
    private int qty;
    private float price;
    private double amount;
    
   static List<ListProduct> list=new ArrayList<>();
}
