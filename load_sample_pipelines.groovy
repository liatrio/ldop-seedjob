folder('sample_pipelines')

samplePipelines = readFileFromWorkspace('sample_pipelines.txt')
samplePipelines.eachLine { line ->
  (repoUrl,branchName) = line.split('#')
  pipelineJob("sample_pipelines/${branchName}") {
    scm {
      git {
        remote {
          url(repoUrl)
        }
        branch(branchName)
      }
    }
  }
}

