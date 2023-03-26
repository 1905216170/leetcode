import cn.hutool.core.date.StopWatch;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.function.BiConsumer;

public class Test implements BeanFactoryPostProcessor, BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            print("生产数据分片1");
            sleep(1);
//            int i = 1/0;
            print("生产完数据分片1");
            return "数据分片1";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            print("生产数据分片2");
            sleep(3);
//            int i = 1/0;
            print("生产完数据分片2");
            return "数据分片2";
        });
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> {
            print("生产数据分片3");
            sleep(2);
//            int i = 1/0;
            print("生产完数据分片3");
            return "数据分片3";
        });
        List<CompletableFuture<String>> cfList = new ArrayList();
        cfList.add(cf1);
        cfList.add(cf2);
        cfList.add(cf3);
        CompletableFuture[] completableFutures = cfList.toArray(new CompletableFuture[cfList.size()]);
        CompletableFuture<String> cf = CompletableFuture.allOf(completableFutures).thenApplyAsync(data -> {
            System.out.println(data);
            print("所有分片均已生产完毕....");
            print("开始整理所有分片数据");
            StringBuilder result = new StringBuilder();
            cfList.stream().forEach(item -> {
                if (!item.isCompletedExceptionally()) {
                    result.append(item.join() + " **");
                }
            });
            print("分片数据整理完毕，将数据进行返回");
            return result.toString();
        }).exceptionally(exception -> {
            System.out.println("发现异常..." + exception);
            return "错误数据";
        });
        print(cf.join());
        new ConcurrentHashMap<>().put(, )


//                whenComplete((data, exception)->{
//            print(exception.toString());
//            print("所有分片均已生产完毕....");
//            print("开始整理所有分片数据");
//            StringBuilder result = new StringBuilder();
//            cfList.stream().forEach(cf -> {
//                if(!cf.isCompletedExceptionally()){
//                    result.append(cf.join() + " *****");
//                }
//            });
//            print("分片数据整理完毕-------------：" + result.toString());
//        });
        LockSupport.park();


//        CompletableFuture.supplyAsync(() -> {
//            print("生产数据分片1");
//            sleep(1);
////            int i = 1/0;
//            print("生产完数据分片1");
//            return "数据分片1";
//        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
//            print("生产数据分片2");
//            sleep(2);
//            print("生产完数据分片2");
//            return "数据分片2";
//        }), (data1, data2)->{
//            print(data1 + " " + data2);
//        }).exceptionally(exception -> {
//            System.out.println("发现异常....");
//            exception.printStackTrace();
//            return null;
//        });
    }

    public static void print(String data){
        System.out.println(LocalDateTime.now().toString() + "-" + Thread.currentThread().getName()  + "：" + data);
    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
