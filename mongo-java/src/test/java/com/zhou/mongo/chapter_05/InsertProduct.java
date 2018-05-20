/**
 * Date:     2018/5/1922:48
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05;

import com.zhou.mongo.chapter_05.service.*;
import com.zhou.mongo.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 插入测试数据
 * 2018/5/19  22:48
 * created by zhoumb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertProduct {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CatgoryAncestorService catgoryAncestorService;

    @Autowired
    private CatgoriesService catgoriesService;

    private AtomicInteger no = new AtomicInteger(10000);

    private static final String[] COLOR = new String[]{"red", "blue", "green", "pink", "bark", "black", "orange", "yellow"};
    private static final int length = COLOR.length;
    private Random random = new Random();

    @Test
    public void insert() {

        List<User> users = new ArrayList<>(50);
        //先创建50个用户
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setUsername("zhou" + i);
            user.setPassword("password" + i);
            user.setName("周" + i);
            user.setAddress("深圳");
            user.setPhone(11100000000L + i);

            users.add(user);
        }
        List<User> userList = userService.saveAll(users);

        List<CatgoryAncestor> catgoryAncestors = new ArrayList<>();
        //创建父分类
        CatgoryAncestor catgoryAncestor = new CatgoryAncestor();
        for (int i = 0; i < 10; i++) {
            catgoryAncestor.setName("父分类"+ i);
            catgoryAncestor.setSlug("父分类"+i + "slug");
            catgoryAncestor.setParend_id("");
            catgoryAncestors.add(catgoryAncestor);
        }
        List<CatgoryAncestor> catgoryAncestors1 = catgoryAncestorService.saveAll(catgoryAncestors);

        //创建分类
        List<Categories> categories = new ArrayList<>(5);
        for (int i = 0; i < 30; i++) {
            Categories categories1 = new Categories();
            categories1.setName("衣帽分类:" + i);
            categories1.setAncestors(catgoryAncestors1.get(random.nextInt(10)));
            categories1.setParent_id("");
            categories1.setDescription("this is yiumao cat:" + i);
            categories1.setSlug("yimao"+i+ "slug");
            categories.add(categories1);
        }
        List<Categories> categoriesList = catgoriesService.saveAll(categories);


        List<Product> products = new ArrayList<>();

        Product product = null;
        for (int i = 0; i < 200; i++) {
            product = new Product();
            product.setId(UUID.randomUUID().toString().substring(0, 17).replaceAll("-", ""));
            product.setName("商品：" + i);
            product.setSku(Integer.toString(no.getAndIncrement()));
            product.setSlug(product.getName() + "-sku-" + product.getSku());
            product.setDescription("手动添加测试商品" + i);

            ProductDetail productDetail = new ProductDetail();
            productDetail.setColor(COLOR[random.nextInt(length)]);
            productDetail.setManufacturer("zhou hasgood " + i);//制造商
            productDetail.setWeight(random.nextInt(1000));
            productDetail.setWeigth_units("g");

            product.setDetails(productDetail);
            int total_reviews = random.nextInt(20);
            product.setTotal_reviews(Long.valueOf(total_reviews));
            //给商品添加对应数量的评价
            List<Review> reviews = new ArrayList<>(total_reviews);
            for (int j = 0; j < total_reviews; j++) {
                Review review = new Review();
                review.setDate(new Date());
                review.setProduct_id(product.getId());
                review.setTitle("商品" + i + "的评价：" + j);
                review.setText("this is amazing");
                review.setRating(Long.valueOf(random.nextInt(5)));
                User user = userList.get(random.nextInt(userList.size()));
                review.setUser_id(user.getId());
                review.setUsername(user.getUsername());
                review.setHelpful_votes(Long.valueOf(random.nextInt(20)));
                String[] voter_ids = new String[review.getHelpful_votes().intValue()];
                for (int k = 0; k < review.getHelpful_votes(); k++) {
                    voter_ids[k] = userList.get(random.nextInt(userList.size())).getId();
                }
                review.setVoter_ids(voter_ids);
                reviews.add(review);
            }
            List<Review> reviews1 = reviewService.saveAll(reviews);
            Long total = 0L;
            for (Review review:
                 reviews1) {
                total += review.getRating();
            }

            product.setAverage_review(Double.valueOf(total.toString()) / reviews1.size());

            //价格
            ProductPrice productPrice = new ProductPrice();
            productPrice.setRetail(random.nextLong());
            productPrice.setSale(productPrice.getRetail()-1000);
            product.setPricing(productPrice);

            PriceHistory[] priceHistories = new PriceHistory[random.nextInt(20)];
            //历史价格
            for (int j = 0; j < priceHistories.length; j++) {
                PriceHistory priceHistory = new PriceHistory();
                priceHistory.setRetail(random.nextLong());
                priceHistory.setSale(priceHistory.getRetail()-1000);
                priceHistories[j] = priceHistory;
            }
            product.setPrice_histoty(priceHistories);
            product.setPrimary_category("衣帽");
            product.setCategory_ids(new String[]{categoriesList.get(random.nextInt(categoriesList.size())).getId(),categoriesList.get(random.nextInt(categoriesList.size())).getId(),categoriesList.get(random.nextInt(categoriesList.size())).getId()});
            product.setMain_cat_id(product.getCategory_ids()[random.nextInt(3)]);
            product.setTags(new String[]{"合身","漂亮","适合"});


            products.add(product);
        }
        boolean b = productService.addProduct(products);
        System.out.println(b);
    }
}
