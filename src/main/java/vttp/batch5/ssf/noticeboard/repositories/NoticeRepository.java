package vttp.batch5.ssf.noticeboard.repositories;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import vttp.batch5.ssf.noticeboard.services.NoticeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class NoticeRepository {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	@Qualifier("notice")
	private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

	// TODO: Task 4
	// You can change the signature of this method by adding any number of parameters
	// and return any type
	// 
	/*
	 * Write the redis-cli command that you use in this method in the comment. 
	 * For example if this method deletes a field from a hash, then write the following
	 * redis-cli command 
	 * 	hdel myhashmap a_key
	 *
	 *
	 */

	//redis-cli
	//Hget key field value
	public void insertNotices() {
// this is my physido code
//		get all by the timestamp and save it as a map
//				then i opsforHash to save it in in redis
//		public Optional<NoticeService> getPayload(Number postDate){
//
//		}




	}


}
