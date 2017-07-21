folder('sample_pipelines')

samplePipelines = new File('./sample_pipelines.txt')
samplePipelines.eachLine { line ->
  repoUrl,branchName = line.split('|')
  pipelineJob("sample_pipelines/${branch}") {
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

