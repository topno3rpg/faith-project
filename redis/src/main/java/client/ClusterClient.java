package client;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 2017/4/26.
 */
public class ClusterClient {

    public static void main(String[] args) throws IOException {
        Config config = Config.fromJSON(new File(ClusterClient.class.getResource("/").getPath() + "redis_cluster_config.json"));
        RedissonClient redissonClient = Redisson.create(config);
        System.out.println(redissonClient.getKeys());
    }

}
