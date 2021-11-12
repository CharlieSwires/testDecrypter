package secondary;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Copyright 2021 Charles Swires All Rights Reserved
 * @author charl
 *
 */
public interface SecondaryMongoBeanRepository extends MongoRepository<secondary.SecondaryMongoBean, String>{

    public List<SecondaryMongoBean> findAll();

	@SuppressWarnings("unchecked")
    public SecondaryMongoBean save(SecondaryMongoBean entity);
	
    public Optional<SecondaryMongoBean> findById(String id);
    public void deleteById(String id);

////	@Query("{ 'firstname' : ?0, 'surname' : ?1 }")
//	public void deleteByFirstnameSurname(String firstname, String surname);
	
    @Query("{ 'firstname' : ?0, 'surname' : ?1 }")
    public SecondaryMongoBean findByFirstnameSurname(String firstname, String surname);
    public List<SecondaryMongoBean> findBySurnameOrderByFirstname(String surname);

    public List<SecondaryMongoBean> findByFirstnameOrderBySurname(String firstname);

	
//	@Query("{ 'name' : { $regex: '?0.*?1.*' } }")
//	public List<MongoBean> findBeansByRegexpFirstSecond(String first, String second);
}
