<template>
  <div>
    <v-container class="text-right">
      <v-btn id="home-login" :to="{name: 'patient-home'}">Home</v-btn>
      <v-btn id="home-logout" :to="{name: 'logout'}">Logout</v-btn>
    </v-container>  
    <v-card v-if="showForm === false">
        <v-card-title>{{patient.firstName}} {{patient.lastName}}</v-card-title>
        <v-card-text>{{patient.dateOfBirth}}</v-card-text>
        <v-card-text>{{patient.patientAddress}}</v-card-text>
        <a id="update-patient-form" href="#" v-if="showForm === false"
         v-on:click.prevent="showForm = true">Update Information?</a>    
    </v-card> 
        <v-card @submit.prevent="updatePatient"
            v-if="showForm === true">
               <v-text-field
                id="firstName"
                prepend-icon="person"
                class="patientInfo"
                label="First Name"
                v-model="updatedPatient.firstName"
                required
                outlined
                autofocus
                ></v-text-field>
                <v-text-field
                id="lastName"
                prepend-icon="person"
                class="patientInfo"
                label="Last Name"
                v-model="updatedPatient.lastName"
                required
                outlined
                ></v-text-field>
                <v-menu
                v-model="dateOfBirthMenu"
                :close-on-content-click="false"
                :nudge-right="40"
                transition="scale-transition"
                offset-y 
                max-width="290px"
                min-width="290px">
                <template v-slot:activator="{ on }">
                <v-text-field
                    label="Date Of Birth"
                    prepend-icon="event"
                    readonly
                    v-on="on"
                    id="dateOfBirth"
                    class="patientInfo"
                    v-model="updatedPatient.dateOfBirth"
                    outlined
                ></v-text-field>
                </template>
                <v-date-picker
                locale="en-in"
                v-model="updatedPatient.dateOfBirth"
                no-title
                @input="dateOfBirthMenu = false"
                :max="today"
                ></v-date-picker>
                </v-menu>
                <v-text-field
                id="address"
                prepend-icon="location_on"
                class="patientInfo"
                label="Address"
                v-model="updatedPatient.patientAddress"
                required
                outlined
                ></v-text-field>
                <v-btn color="green" type="submit">Submit</v-btn>
                <v-btn color="red" type ="button"
                @click.prevent="resetForm">Cancel</v-btn>
         </v-card>
  </div>    
</template>

<script>
import PatientService from '../services/PatientService'
export default {
    name: 'patient-information',
    data: () => ({
        showForm: false,
        patient: {},
        updatedPatient: {}
    }),
    created() {
        PatientService.getLoggedInPatient(this.$store.state.user.id).then(response => {
            this.patient = response.data;
        })
    },
    methods: {
        resetForm() {
            this.showForm = false;
            this.updatedPatient = {};
        },
        updatePatient() {
        }
    }
}
</script>

<style>

</style>