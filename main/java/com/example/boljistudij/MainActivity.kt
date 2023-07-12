package com.example.boljistudij

import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.boljistudij.databinding.ActivityMainBinding
import com.example.boljistudij.views.status.StatusViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewBinding: ActivityMainBinding by viewBinding(
        ActivityMainBinding::bind,
        R.id.root_container
    )

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onStart() {
        super.onStart()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        navController = findNavController(R.id.nav_host_fragment_container)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splash_fragment, R.id.login_fragment -> hideBottomNavigation()
                else -> {
                    showBottomNavigation()
                }
            }
        }
        viewBinding.bottomNavigation.setupWithNavController(navController)
    }

    fun showBottomNavigation(transition: Transition = Slide(Gravity.BOTTOM)) {
        if (viewBinding.bottomNavigation.visibility != View.VISIBLE) {
            TransitionManager.beginDelayedTransition(viewBinding.bottomNavigation, transition)
            viewBinding.bottomNavigation.visibility = View.VISIBLE
        }
    }

    fun hideBottomNavigation(transition: Transition = Slide(Gravity.BOTTOM)) {
        TransitionManager.beginDelayedTransition(viewBinding.bottomNavigation, transition)
        viewBinding.bottomNavigation.visibility = View.GONE

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    fun showStatusView(state: StatusViewState) {
        viewBinding.statusView.setupState(state)
    }

    fun showLoader() {
        viewBinding.progressBarCircular.show()
    }

    fun hideLoader() {
        viewBinding.progressBarCircular.hide()
    }
}