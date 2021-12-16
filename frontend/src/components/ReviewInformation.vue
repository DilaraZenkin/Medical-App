<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card 
            v-bind:key="review.id"
            v-for="review in reviews">
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>{{review.officeName}}</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <div class="text--primary">
                 Office Address: {{review.officeAddress}}
                  
                </div>
                <p class="text-h4 text--primary">{{review.address}}</p>
                <p>Doctor: {{review.doctorLast}}</p>
                <div class="text--primary">
                 Review Score: {{review.score}} 
                </div>
                <div class="text--primary">
                 Review: {{review.reviewBody}}
                  
                </div>
                <div class="text--primary">
                 Response: {{review.response}}
                  
                </div>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import reviewService from "../services/ReviewService";
export default {
  name: "patient-review",
 data: () => ({
    loading: false,
    selection: 1,
    reviews: [],
  }),
  created() {
    reviewService.getReviews().then((response) => {
      this.reviews = response.data;
      this.isLoading = false;
    });
  },
  methods: {
    reserve() {
      this.loading = true;
      setTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>

<style>
</style>