import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Patient from '../views/Patient.vue'
import Doctor from '../views/Doctor.vue'
import store from '../store/index'
import DoctorHome from '../views/DoctorHome.vue'
import PatientHome from '../views/PatientHome.vue'
import PatientRegistration from '../views/PatientRegistration.vue'
import DoctorRegistration from '../views/DoctorRegistration.vue'

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
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
<<<<<<< HEAD
      path: "/doctor",
      name: "doctor",
      component: Doctor,
=======
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
>>>>>>> cb646d27976c522ebd759ebff9bc2d5c1fcd1a9e
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/doctor/:doctorId",
      name: "doctor-home",
      component: DoctorHome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/patient",
      name: "patient",
      component: Patient,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/patient/:patientId",
      name: "patient-home",
      component: PatientHome,
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
