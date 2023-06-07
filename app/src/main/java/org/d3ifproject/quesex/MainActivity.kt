package org.d3ifproject.quesex

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.d3ifproject.quesex.databinding.ActivityMainBinding
import org.d3ifproject.quesex.model.MainViewModel
import org.d3ifproject.quesex.ui.GameFragment
import org.d3ifproject.quesex.ui.MainFragment
import org.d3ifproject.quesex.ui.ProfileFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, GameFragment())
//            .commit()

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navController = findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment, R.id.profileFragment,).build()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) //ini emang aman kok walaupun merah
            .requestEmail()
            .build()

        mGoogleSignInClient= GoogleSignIn.getClient(this,gso)

        FirebaseAuth.getInstance()


//        navController = findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this, navController)
//        navController = Navigation.findNavController(
//            this, R.id.myNavHostFragment
//        )
//        setupWithNavController(binding.bottomNavigationView, navController)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> {
//                // Tindakan ketika tombol kembali ditekan, misalnya:
//                onBackPressed()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
//    }


    // membuat dialog exit
    override fun onBackPressed() {
        // inisialisasi alert dialog
        val builder = AlertDialog.Builder(this)

        // mengeset judul dialog
        builder.setTitle(R.string.app_name)

        // mengeset pesan dialog
        builder.setMessage(R.string.exit_dialog)

        // jika ya
        builder.setPositiveButton("Ya") { _, _ ->
            this.finish()
        }

        // jika tidak
        builder.setNegativeButton("Tidak") { _, _ -> }

        // dialog tidak bisa kembali / cancel
        builder.setCancelable(false)

        // menampilkan dialog
        builder.show()
    }
}