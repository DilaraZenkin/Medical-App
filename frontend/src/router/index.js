import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import RegisterChoice from '../views/RegisterChoice.vue'
import store from '../store/index'
import DoctorList from '../components/DoctorList.vue'
import DoctorHome from '../views/DoctorHome.vue'
import PatientHome from '../views/PatientHome.vue'
import PatientRegistration from '../views/PatientRegistration.vue'
import DoctorRegistration from '../views/DoctorRegistration.vue'
import PatientInformation from '../components/PatientInformation.vue'
import OfficeforEachDoctor from '../components/OfficeforEachDoctor'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: RegisterChoice,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register/doctor",
      name: "doctor-register",
      component: DoctorRegistration,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register/patient",
      name: "patient-register",
      component: PatientRegistration,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/doctors",
      name: "doctor-list",
      component: DoctorList,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/doctors/home",
      name: "doctor-home",
      component: DoctorHome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/patients/home",
      name: "patient-home",
      component: PatientHome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/patients/information",
      name: "patient-information",
      component: PatientInformation,
      meta: {
        requiresAuth: true
      }
    },

      {
        path: "/doctors/office",
        name: "doctor-office",
        component: OfficeforEachDoctor,
        meta: {
          requiresAuth: true

      }
    
      
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
