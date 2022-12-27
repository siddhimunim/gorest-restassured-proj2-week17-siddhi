package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsAssertaionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2";

        response = given()

                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);

    }
// 1. Verify the if the total record is 20
 @Test
   public void verifyTotal(){
     response.body("size()",equalTo(25));
   }
//2. Verify the if the title of id = 2622 is equal to Caput adipiscor unus crux arcesso admiratio bellicus ut cum est aufero supellex bestia basium.
@Test
public void verifyTitle(){
    response.body("findAll{it.id==2622}.title",hasItem("Caput adipiscor unus crux arcesso admiratio bellicus ut cum est aufero supellex bestia basium."));
}
//  3. Check the single user_id in the Array list (5437)
@Test
public void verifyUserId(){
    response.body("[0].user_id",equalTo(5437));
}
//4. Check the multiple ids in the ArrayList (2670, 2665,)
@Test
public void verifyMultipleId(){
    response.body("id",hasItems(2670,2665));
}
//5. Verify the body of userid = 5397 is equal to
    @Test
    public void verifyBody(){
        response.body("findAll{it.user_id==5397}.body",hasItem("Consequatur adultus adsidue. Doloremque curatio est. Deporto supra est. Solium aut denego. Compono usque veniam. Aperio contego adipiscor. Ulterius assumenda ancilla. Spoliatio arx suus. Absorbeo cornu paulatim. Conturbo tyrannus super. Suscipio voluptate strenuus. Adulatio assumenda basium. Aperio capitulus vespillo. Sed dens balbus. Thalassinus alter coerceo. Sol acer altus. Aufero ipsa vere. Teneo reiciendis debitis. Culpa antea non."));
    }

}
