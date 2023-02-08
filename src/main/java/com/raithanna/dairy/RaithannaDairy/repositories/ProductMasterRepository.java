package com.raithanna.dairy.RaithannaDairy.repositories;

import com.azure.spring.data.cosmos.repository.Query;
import com.raithanna.dairy.RaithannaDairy.models.productMaster;
import com.raithanna.dairy.RaithannaDairy.models.userModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;


public interface ProductMasterRepository extends CrudRepository<productMaster, Integer> {
    @Query("select * from product_master where splcustcode=?1 ")
    Iterable<productMaster> findBySplCustCode(String splcustcode);
    @Query("select * from product_master where splcustcode=?1 and PCode=?2")
    productMaster findBySplCustCodeAndPCode(String splcustcode,String PCode);
}
