<template>

    <v-data-table
        :headers="headers"
        :items="reportDashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReportDashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "deviceId", value: "deviceId" },
                { text: "userId", value: "userId" },
                { text: "reviewerId", value: "reviewerId" },
                { text: "createdAt", value: "createdAt" },
                { text: "updatedAt", value: "updatedAt" },
                { text: "reportStatus", value: "reportStatus" },
            ],
            reportDashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reportDashboards'))

            temp.data._embedded.reportDashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reportDashboard = temp.data._embedded.reportDashboards;
        },
        methods: {
        }
    }
</script>

