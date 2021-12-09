<template>

<v-app id="inspire">
      <v-content class="main">
         <v-container fluid>
            <v-layout justify-center align-center>
               <v-flex xs12 sm8 md4>
                  <v-card>
                     <v-toolbar dark color="primary">
                        <v-toolbar-title>Create Account</v-toolbar-title>
                     </v-toolbar>
                     <v-card-text>
                        <v-form @submit.prevent="register">
                           <v-text-field
                              prepend-icon="person"
                              id="username"
                              class="form-control"
                              label="Username"
                              v-model="user.username"
                              required
                              outlined
                              autofocus
                           ></v-text-field>
                           <v-text-field
                              id="password"
                              prepend-icon="lock"
                              type="password"
                              class="form-control"
                              label="Password"
                              v-model="user.password"
                              required
                              outlined
                           ></v-text-field>
                           <v-text-field
                              id="confirmPassword"
                              prepend-icon="enhanced_encryption"
                              type="password"
                              class="form-control"
                              label="Confirm Password"
                              v-model="user.confirmPassword"
                              required
                              outlined
                           ></v-text-field>
                            <!--<v-checkbox
                            prepend-icon="people"
                            id="is-doctor"
                            class="form-control"
                            v-model="user.isDoctor"
                            label="Are you a doctor?"
                            ></v-checkbox> -->
                            <v-text-field
                            id="firstName"
                            class="personInfo"
                            label="First Name"
                            prepend-icon="person_outline"
                            v-model="patient.firstName"
                            required
                            outlined
                            autofocus
                            ></v-text-field>
                            <v-text-field
                            id="lastName"
                            class="personInfo"
                            label="Last Name"
                            prepend-icon="person_outline"
                            v-model="patient.lasttName"
                            required
                            outlined
                            autofocus
                            ></v-text-field>
                             <!-- <v-date-picker
                            id="dateOfBirth"
                            class="personInfo"
                            v-model="patient.dateOfBirth"
                            required
                            ></v-date-picker> -->
                            <v-menu
                              v-model="dateOfBirthMenu"
                              :close-on-content-click="false"
                              :nudge-right="40"
                              transition="scale-transition"
                              offset-y 
                              max-width="290px"
                              min-width="290px"
                            >
                              <template v-slot:activator="{ on }">
                                <v-text-field
                                  label="Date Of Birth"
                                  prepend-icon="event"
                                  readonly
                                  v-on="on"
                                  id="dateOfBirth"
                                  class="personInfo"
                                  v-model="patient.dateOfBirth"
                                  outlined
                                ></v-text-field>
                              </template>
                              <v-date-picker
                                locale="en-in"
                                v-model="patient.dateOfBirth"
                                no-title
                                @input="dateOfBirthMenu = false"
                                :max="today"
                              ></v-date-picker>
                            </v-menu>
                            <v-text-field
                            id="address"
                            class="personInfo"
                            label="Address"
                            prepend-icon="location_on"
                            v-model="patient.patientAddress"
                            required
                            outlined
                            autofocus
                            ></v-text-field>
                           <v-card-actions>
                              <router-link :to="{ name: 'login' }">Have an account?</router-link>
                              <v-spacer></v-spacer>
                              <v-btn color="primary" type="submit">Create Account</v-btn>
                          </v-card-actions>
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
