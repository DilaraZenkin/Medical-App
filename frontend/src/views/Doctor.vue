<template>
  <div id="app">
  <v-app id="inspire">
    <v-card
      class="mx-auto"
      width="80%"
      outlined
      v-bind:key="patient.id"
      v-for="patient in patients"
    >
      <v-list-item three-line>
        <v-list-item-content>
          <div class="text-overline mb-4">
            {{patient.firstName}}{{patient.lastName}}
          </div>
          <v-list-item-title class="text-h5 mb-1">
            Appointment Time
          </v-list-item-title>
          <v-list-item-subtitle>Greyhound divisely hello coldly fonwderfully</v-list-item-subtitle>
        </v-list-item-content>
  
        <v-list-item-avatar
          tile
          size="80"
          color="grey"
        ></v-list-item-avatar>
      </v-list-item>
  
      <v-card-actions>
        <v-btn
          outlined
          rounded
          text
          color="deep-purple lighten-2"
        >
          View Details
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-app>
</div>
</template>

<script>
import patientService from '../services/PatientService'
export default {
  name: "Doctor",
  data: () => ({
    loading: false,
    selection: 1,
    patients: []
  }),
  created() {
    patientService.getPatients().then(response => {
      this.patients = response.data;
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