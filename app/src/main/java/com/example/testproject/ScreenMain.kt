import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testproject.LoginPage
import com.example.testproject.Magazines
import com.example.testproject.MainActivity
import com.example.testproject.Routes
import com.example.testproject.ViewModels.LoginViewModel
import com.example.testproject.ViewModels.MagazineViewModel

@Composable
fun ScreenMain(){
    val navController = rememberNavController()
    val accessToken = MainActivity.userPreferences.getAccessToken()
    val startingPoint : String = if(accessToken.isNullOrEmpty()){
        Routes.Login.route
    }else{
        Routes.Magazines.route
    }

    NavHost(navController = navController, startDestination = startingPoint) {

        composable(Routes.Login.route) {

            LoginPage(loginViewModel = LoginViewModel(), onNavigateToMagazines = { navController.navigate(Routes.Magazines.route) })

        }


        composable(Routes.Magazines.route) {
            Magazines(magazineViewModel = MagazineViewModel())
        }
    }
}