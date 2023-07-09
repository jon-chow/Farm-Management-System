import type { JestConfigWithTsJest } from "ts-jest";

const JestConfig: JestConfigWithTsJest = {
	moduleNameMapper: {
		"^@/(.*)$": "<rootDir>/src/$1",
	},
};

export default JestConfig;
