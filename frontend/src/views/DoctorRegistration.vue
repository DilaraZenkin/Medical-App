<template>

<v-app id="inspire">
      <v-content class="main">
         <v-container fluid>
            <v-layout justify-center align-center>
               <v-flex xs12 sm8 md4>
                  <v-card>
                     <v-toolbar dark color="primary">
                        <v-toolbar-title>Create New Doctor Account</v-toolbar-title>
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
                            <v-text-field
                            id="firstName"
                            prepend-icon="person_outline"
                            class="doctorInfo"
                            label="First Name"
                            v-model="doctor.firstName"
                            required
                            outlined
                            autofocus
                            ></v-text-field>
                             <v-text-field
                            id="lastName"
                            prepend-icon="person_outline"
                            class="doctorInfo"
                            label="Last Name"
                            v-model="doctor.lastName"
                            required
                            outlined
                            autofocus
                            ></v-text-field>
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
                                  class="doctorInfo"
                                  v-model="doctor.dateOfBirth"
                                  outlined
                                ></v-text-field>
                              </template>
                              <v-date-picker
                                locale="en-in"
                                v-model="doctor.dateOfBirth"
                                no-title
                                @input="dateOfBirthMenu = false"
                                :max="today"
                              ></v-date-picker>
                            </v-menu>
                             <v-text-field
                            id="address"
                            prepend-icon="location_on"
                            class="doctorInfo"
                            label="Office Id"
                            v-model="doctor.officeId"
                            type="number"
                            min="1"
                            max="2"
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
import DoctorService from '../services/DoctorService';

export default {
  name: 'doctor-register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'admin'
      },
      doctor: {
        doctorId: '',
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        officeId: ''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.'
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
            this.doctor.doctorId = response.data;
            DoctorService.addDoctor(this.doctor)
            .then((doctorResponse) => {
              if (doctorResponse.status == 201) {
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
  }
};
</script>

<style scoped>
  .main {
    padding-top: 8px !important;
  }
</style>
