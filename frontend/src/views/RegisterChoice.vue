<template>

<v-app id="inspire">
      <v-content class="main">
         <v-container fluid>
            <v-layout justify-center align-center>
               <v-flex xs12 sm8 md8>
                  <v-card>
                     <v-toolbar dark color="#1A5276">
                        <v-toolbar-title>Create Account</v-toolbar-title>
                     </v-toolbar>
                     <v-card-text>
                        <v-form>
                           <v-card-actions>
                              <v-btn color="primary" :to="{name: 'patient-register'}">Patient Account</v-btn>
                              <v-spacer></v-spacer>
                              <v-btn color="primary" :to="{name: 'doctor-register'}">Doctor Account</v-btn>
                          </v-card-actions>
                          <v-layout justify-center>
                            <router-link :to="{ name: 'login' }">Have an account?</router-link>
                          </v-layout>
                        </v-form>
                     </v-card-text>
                  </v-card>
               </v-flex>
            </v-layout>
         </v-container>
      </v-content>
   </v-app>
</template>
<script>
import authService from '../services/AuthService';
import PatientService from '../services/PatientService'

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        isDoctor: true,
      },
      patient: {
        patientId: '',
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        address: ''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
      dateOfBirthMenu: false
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            this.patient.patientId = response.data;
            PatientService.addPatient(this.patient)
            .then((patientResponse) => {
              if (patientResponse.status == 201) {
                this.$router.push({
                  path: '/login',
                  query: { registration: 'success' },
                });
              }
            })
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
  computed: {
    today() {
      var today = new Date();
      var dd = String(today.getDate()).padStart(2, '0');
      var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
      var yyyy = today.getFullYear();
      return yyyy + '-' + mm + '-' + dd;
    },
 
  },
  changeDoctorStatus() {
    this.user.isDoctor = false;
  }
};
</script>

<style scoped>
  .main {
    padding-top: 8px !important;
  }
</style>
