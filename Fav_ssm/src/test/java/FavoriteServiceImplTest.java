
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.fav.entity.Favorite;
import com.yc.fav.service.FavoriteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FavoriteServiceImplTest {
	@Autowired
	private  FavoriteService favoriteService;
	@Test
	public void testAddFavorite() {
		Favorite fav=new Favorite("mybatis","www.bybaits.com","mybaits","assa");
		favoriteService.addFavorite(fav);
	}

}
