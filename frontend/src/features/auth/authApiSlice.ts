import { apiSlice } from "@/api/apiSlice";
import { logOut, setCredentials } from "./authSlice";


/**
 * Auth API slice.
 * TODO: implement this
 */
export const authApiSlice = apiSlice.injectEndpoints({
	endpoints: (builder) => ({
		// Login.
		login: builder.mutation({
			query: (credentials) => ({
				url: "/auth",
				method: "POST",
				body: { ...credentials },
			}),
		}),

		// Logout.
		// sendLogout: builder.mutation({
		// 	query: (id) => ({
		// 		url: `/auth/logout`,
		// 		method: "POST",
		// 	}),
		// 	async onQueryStarted(arg, { dispatch, queryFulfilled }) {
		// 		try {
		// 			const { data } = await queryFulfilled;
		// 			dispatch(logOut(""));
		// 			setTimeout(() => {
		// 				dispatch(apiSlice.util.resetApiState());
		// 			}, 1000);
		// 		} catch (err) {
		// 			// console.log(err);
		// 		}
		// 	},
		// }),

		// Refresh.
		// refresh: builder.mutation({
		// 	query: () => ({
		// 		url: "/auth/refresh",
		// 		method: "GET",
		// 	}),
		// 	async onQueryStarted(arg, { dispatch, queryFulfilled }) {
		// 		try {
		// 			const { data } = await queryFulfilled;
		// 			const { accessToken } = data;
		// 			dispatch(setCredentials({ accessToken }));
		// 		} catch (err) {
		// 			// console.log(err);
		// 		}
		// 	},
		// }),
	}),
});

export const {
	useLoginMutation,
	// useSendLogoutMutation,
	// useRefreshMutation,
} = authApiSlice;
