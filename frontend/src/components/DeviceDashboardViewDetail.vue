<template>

    <v-card outlined>
        <v-card-title>
            DeviceDashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Imei" v-model="item.imei" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PhoneNumber" v-model="item.phoneNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DeviceStatus" v-model="item.deviceStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="CreatedAt" v-model="item.createdAt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="UpdatedAt" v-model="item.updatedAt" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DeviceDashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/deviceDashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

