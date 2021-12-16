<template>
  <v-app id="inspire">
      <v-content class="main">
         <v-container fluid>
            <v-layout justify-center align-center>
               <v-flex xs12 sm8 md14>
                  <v-card>
                     <v-toolbar dark color="#1A5276">
                        <v-toolbar-title>Login User</v-toolbar-title>
                     </v-toolbar>
                     <v-card-text>
                        <v-form @submit.prevent="login">
                           <v-text-field
                              prepend-icon="person"
                              label="Username"
                              v-model="user.username"
                              required
                              autofocus
                              outlined
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
                           <v-card-actions>
                              <router-link :to="{ name: 'register' }">Need an account?</router-link>
                              <v-spacer></v-spacer>
                              <v-btn color="#1A5276" dark type="submit">Login</v-btn>
                          </v-card-actions>
                        </v-form>
                     </v-card-text>
                  </v-card>
               </v-flex>
            </v-layout>
         </v-container>
      </v-content>
         <div id="app">
  <v-app id="inspire">
    <v-container fluid>
      <v-row align="center" justify="center">
        <v-col cols="3">


          <v-img
            src="../logo/logo.png"
            rounded="circle"
            aspect-ratio="0.75"
              max-height="250"
            max-width="200"
          ></v-img>
             </v-col>
      </v-row>
    </v-container>
  </v-app>
</div>
   </v-app>

</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            if (response.data.user.authorities[0].name == "ROLE_ADMIN") {
              this.$router.push("/doctors/home");
            } else {
              this.$router.push("/patient/information");
            }
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>
  .main {
    padding-top: 8px !important;
  }

  #inspire {
justify-items: center;
  }
</style>