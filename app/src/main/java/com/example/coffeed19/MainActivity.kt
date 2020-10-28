package com.example.coffeed19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.coffeed19.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Communicator {

    private val fragmenthome: Fragment = HomeFragment()
    private val fragmentkopipedia: Fragment = KopipediaFragment()
    private val fragmentstatus: Fragment = StatusFragment()
    private val fragmentvoucher: Fragment = VoucherFragment()
    private val fragmentbill: Fragment = billFragment()
    private val fragmentmenu: Fragment = MenuFragment()
    private val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmenthome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomNav()
        val fragmenthome = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragmenthome).commit()
    }

    private fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmenthome) .show(fragmenthome) .commit()
        fm.beginTransaction().add(R.id.container, fragmentkopipedia) .hide(fragmentkopipedia) .commit()
        fm.beginTransaction().add(R.id.container, fragmentstatus) .hide(fragmentstatus) .commit()
        fm.beginTransaction().add(R.id.container, fragmentvoucher) .hide(fragmentvoucher) .commit()
        fm.beginTransaction().add(R.id.container, fragmentbill) .hide(fragmentbill) .commit()


        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home ->{
                    callFragment(0, fragmenthome)
                }
                R.id.navigation_kopipedia ->{
                    callFragment(1, fragmentkopipedia)
                }
                R.id.navigation_status ->{
                    callFragment(2, fragmentstatus)
                }
                R.id.navigation_voucher ->{
                    callFragment(3, fragmentvoucher)
                }
                R.id.navigation_bill ->{
                    callFragment(4, fragmentbill)
                }
                R.id.btn_pesan ->{
                    callFragment( 5, fragmentmenu)
                }
            }


            false
        }
    }
    fun callFragment(int: Int, fragment: Fragment){
        Log.d("Respons","E-Bill")
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("massage", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentmenu = MenuFragment()
        fragmentmenu.arguments = bundle

        transaction.replace(R.id.container, fragmentmenu)
        transaction.commit()
    }

}
