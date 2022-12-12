package org.scelac.d.ex3;

import java.util.Objects;

public class Company {
    private Long id;
    private String name;
    private Profit profit;

    //Constructors and Setters/Getters

//    //Entity
//    public class Ship {
//        private Long id;
//        private Type type;
//        //Constructors and Setters/Getters
//    }
    // Value Object
    public class Type {
        private String type;
        private Integer height;
        private Integer width;
        //Constructors and Setters/Getters
    }

    enum  ShipType {
        CRUISE
    }

    public class Ship {
        private Long id;
        private ShipType type;
        private Company company;
        public Ship(Type type, Company company) {
            if(Objects.isNull(company) || Objects.isNull(type)){
                throw new RuntimeException("Type and Company are required.");
            }
        }
    }

  public class ShipService {
    public Ship createACruiseShip(Company company) {
      if (Objects.isNull(company)) {
        throw new RuntimeException("Company is required.");
      }
      Ship ship = new Ship();
      ship.setType(ShipType.CRUISE);
      ship.setCompany(company);
      return ship;
    }
  }
}


