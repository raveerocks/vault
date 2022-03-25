package io.raveerocks.vault

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import io.raveerocks.vault.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        this.drawerLayout = binding.drawerLayout
        val mainFragmentNavController = this.findNavController(R.id.main_fragment)
        NavigationUI.setupActionBarWithNavController(this,mainFragmentNavController,drawerLayout)
        this.appBarConfiguration = AppBarConfiguration(mainFragmentNavController.graph,drawerLayout)
        mainFragmentNavController.addOnDestinationChangedListener { nc, nd, _ ->
            if (nd.id == nc.graph.startDestinationId) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
        NavigationUI.setupWithNavController( binding.mainNavView,mainFragmentNavController)
    }
}