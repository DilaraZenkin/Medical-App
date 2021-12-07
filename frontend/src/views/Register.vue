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
                            <v-checkbox
                            prepend-icon="people"
                            id="is-doctor"
                            class="form-control"
                            v-model="user.isDoctor"
                            v-on:click="true"
                            label="Are you a doctor?"
                            ></v-checkbox>
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

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        isDoctor: false,
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
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
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
};
</script>

<style scoped>
  .main {
    padding-top: 8px !important;
  }
</style>
